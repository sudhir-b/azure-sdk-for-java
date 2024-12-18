@Service
public class AzureMailService implements MessagingService {
    private final EmailAsyncClient emailClient;
    private final String senderAddress;
    private static final Logger logger = LoggerFactory.getLogger(AzureMailService.class);

    @Autowired
    public AzureMailService(
            @Value("${ch.hygiaso.azure-email.connection-string}")
            String connectionString,
            @Value("${ch.hygiaso.azure-email.sender-address}")
            String senderAddress
    ) {
        emailClient = new EmailClientBuilder()
                .connectionString(connectionString)
                .buildAsyncClient();
        this.senderAddress = senderAddress;
    }

    /**
     * Converts a FileContentDTO to an EmailAttachment with proper base64 encoding
     * @param fileContent The file content to convert
     * @return EmailAttachment ready for the Azure Email service
     */
    private EmailAttachment createEmailAttachment(FileContentDTO fileContent) {
        byte[] base64EncodedContent = Base64.getEncoder().encode(fileContent.getContent());
        return new EmailAttachment(
            fileContent.getName(),
            fileContent.getContentType(),
            BinaryData.fromBytes(base64EncodedContent)
        );
    }

    public void sendMessage(String recipientAddress, String subject, String body, FileContentDTO... attachments) {
        logger.debug("Sending notification email to {}", recipientAddress);
        
        List<EmailAttachment> emailAttachments = attachments != null 
            ? Arrays.stream(attachments)
                .map(this::createEmailAttachment)
                .collect(Collectors.toList())
            : Collections.emptyList();

        EmailMessage message = new EmailMessage()
                .setSenderAddress(senderAddress)
                .setToRecipients(recipientAddress)
                .setSubject(subject)
                .setBodyHtml(body)
                .setAttachments(emailAttachments);

        var poller = emailClient.beginSend(message);
        poller.subscribe(response -> {
                    if (response.getStatus() == LongRunningOperationStatus.SUCCESSFULLY_COMPLETED) {
                        logger.trace("Successfully sent the email (operation id: {})", response.getValue().getId());
                    }
                },
                error -> logger.error("Error occurred while sending email to {}: {}", anonymizeEmailForLogging(recipientAddress), error.getMessage()));
        logger.debug("Email queued for sending");
    }
}