## Task III

The following code filters elements from a collection by statuses to another collection:

### Code

```
final List<FilteringCollection___Task_3.AgentInfoBean> agentInfos = fetchItems();
List<FilteringCollection___Task_3.AgentInfoBean> filteredResults = new LinkedList<FilteringCollection___Task_3.AgentInfoBean>();
for (FilteringCollection___Task_3.AgentInfoBean item : agentInfos) {
    if (states.contains(item.getStatus())) {
        filteredResults.add(item);
    }
}
```

### Code

Rewrite this code using Java8 stream and functions API.