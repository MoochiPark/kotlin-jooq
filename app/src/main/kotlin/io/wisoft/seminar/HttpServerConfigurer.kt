package io.wisoft.seminar

import io.undertow.Undertow
import io.undertow.servlet.api.ConfidentialPortManager
import io.undertow.servlet.api.DeploymentInfo
import io.undertow.servlet.api.SecurityConstraint
import io.undertow.servlet.api.SecurityInfo
import io.undertow.servlet.api.TransportGuaranteeType
import io.undertow.servlet.api.WebResourceCollection
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer
import org.springframework.boot.web.embedded.undertow.UndertowDeploymentInfoCustomizer
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HttpServerConfigurer {

    @Bean
    fun serverFactory(): ServletWebServerFactory? {
        val factory = UndertowServletWebServerFactory()
        // HTTP
        factory.addBuilderCustomizers(
            UndertowBuilderCustomizer { builder: Undertow.Builder ->
                builder.addHttpListener(8080, "0.0.0.0")
            }
        )

        // HTTPS 적용
        factory.addDeploymentInfoCustomizers(
            UndertowDeploymentInfoCustomizer { deploymentInfo: DeploymentInfo ->
                deploymentInfo.addSecurityConstraint(
                    SecurityConstraint()
                        .addWebResourceCollection(WebResourceCollection().addUrlPattern("/*"))
                        .setTransportGuaranteeType(TransportGuaranteeType.CONFIDENTIAL)
                        .setEmptyRoleSemantic(SecurityInfo.EmptyRoleSemantic.PERMIT)
                ).confidentialPortManager = ConfidentialPortManager { 443 }
            }
        )

        return factory
    }
}
