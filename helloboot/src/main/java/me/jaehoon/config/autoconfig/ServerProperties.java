package me.jaehoon.config.autoconfig;

import me.jaehoon.config.MyConfigurationProperties;

// Component scan으로 scanning이 되거나
// Import를 시키거나
@MyConfigurationProperties(prefix = "server") // 변수명 앞에 namespace 처럼 server. 이런식으로 붙는다.
public class ServerProperties {
    private String contextPath;

    private int port;

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
