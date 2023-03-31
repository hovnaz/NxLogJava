package HibernateRepository___Task_4.repository;

import HibernateRepository___Task_4And5.entity.Module;
import HibernateRepository___Task_4And5.model.ModuleType;
import HibernateRepository___Task_4And5.repository.HibernateRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class HibernateRepositoryTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<Module> typedQuery;

    @InjectMocks
    private HibernateRepository repository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetModulesIncludedInCompleteRoutes() {
        Long agentId = 1L;
        List<Module> modules = new ArrayList<>();
        Module module = new Module();
        module.setType(ModuleType.INPUT);
        modules.add(module);

        when(entityManager.createQuery(anyString(), eq(Module.class))).thenReturn(typedQuery);
        when(typedQuery.setParameter(anyString(), any())).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(modules);

        Set<Module> result = repository.getModulesIncludedInCompleteRoutes(agentId);

        assertEquals(1, result.size());
        assertEquals(ModuleType.INPUT, result.iterator().next().getType());

        verify(entityManager, times(1)).createQuery(anyString(), eq(Module.class));
        verify(typedQuery, times(3)).setParameter(anyString(), any());
        verify(typedQuery, times(1)).getResultList();
    }
}
