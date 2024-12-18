# GraalVM Native Image Support for Azure Service Bus JMS

When using Azure Service Bus JMS in a GraalVM native image context (e.g., with Spring Boot Native), you need to add the following reflection configuration to your application:

```java
@ImportRuntimeHints(NativeRuntimeHints.MyRuntimeHintsRegistrar.class)
@Configuration
public class NativeRuntimeHints {
    static class MyRuntimeHintsRegistrar implements RuntimeHintsRegistrar {
        @Override
        public void registerHints(RuntimeHints hints, @Nullable ClassLoader classLoader) {
            // Register Azure ServiceBus JMS classes for reflection
            hints.reflection()
                 .registerType(TypeReference.of("com.azure.servicebus.jms.ServiceBusJmsConnectionFactory"),
                     MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
                     MemberCategory.INVOKE_PUBLIC_METHODS,
                     MemberCategory.DECLARED_FIELDS);
            
            hints.reflection()
                 .registerType(TypeReference.of("com.azure.servicebus.jms.ServiceBusJmsConnectionFactorySettings"),
                     MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
                     MemberCategory.INVOKE_PUBLIC_METHODS,
                     MemberCategory.DECLARED_FIELDS);
                     
            hints.reflection()
                 .registerType(TypeReference.of("com.azure.servicebus.jms.ServiceBusJmsConnectionFactory"),
                     builder -> builder.withConstructor(String.class, TypeReference.of("com.azure.servicebus.jms.ServiceBusJmsConnectionFactorySettings")));
        }
    }
}
```

This configuration ensures that the necessary classes and their members are available for reflection at runtime when using GraalVM native image compilation.