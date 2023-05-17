package nx.log.task.colectionUtil;

public class AgentInfoBean {

    private final String status;

    public AgentInfoBean(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "AgentInfoBean{" +
                "status='" + status + '\'' +
                '}';
    }
}
