package kz.iitu.itse1905.damir.rest_electricity_billing_system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Configuration
@ConfigurationProperties(prefix = "database")
@PropertySource("classpath:/application.properties")
public class DatabaseProperties {
    public static class Server {

        /**
         * The IP of the database server
         */
        private String ip;

        /**
         * The Port of the database server.
         * The Default value is 443.
         * The allowed values are in the range 400-4000.
         */
        @Min(400)
        @Max(800)
        private int port = 443;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }
    }

    @Value("spring.datasource.username")
    private String username;
    @Value("spring.datasource.password")
    private String password;
    private Server server;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
