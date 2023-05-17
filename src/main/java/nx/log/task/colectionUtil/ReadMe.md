## Task III

The following code filters elements from a collection by statuses to another collection:

### Code

```
final List<AgentInfoBean> agentInfos = fetchItems();
List<AgentInfoBean> filteredResults = new LinkedList<AgentInfoBean>();
for (AgentInfoBean item : agentInfos) {
    if (states.contains(item.getStatus())) {
        filteredResults.add(item);
    }
}
```

### Code

Rewrite this code using Java8 stream and functions API.