## Task V

Let's have the above Hibernate model in Task IV and more secificly the Agent entity. We don't need globalConfig each
time in Hibernate and as @Lob this can be large data. Modify the model so globalConfig is only fetched when needed, i.e.
session.get(agentId, Agent.class) will return Agent without globalConfig data.
