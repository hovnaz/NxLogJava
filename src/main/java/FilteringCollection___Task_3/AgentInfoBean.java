package FilteringCollection___Task_3;

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
        return "FilteringCollection___Task_3.AgentInfoBean{" +
                "status='" + status + '\'' +
                '}';
    }
}
