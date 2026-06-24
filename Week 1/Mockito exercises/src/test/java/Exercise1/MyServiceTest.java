import static org.mockito.Mockito.*; 
import org.junit.jupiter.api.Test; 
import org.mockito.Mockito; 
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyServiceTest { 
    @Test 
    public void testExternalApi() { 
        // 1. Create a mock object for the external API.
        ExternalApi mockApi = Mockito.mock(ExternalApi.class); 
        
        // 2. Stub the methods to return predefined values.
        when(mockApi.getData()).thenReturn("Mock Data"); 
        
        // 3. Write a test case that uses the mock object.
        MyService service = new MyService(mockApi); 
        String result = service.fetchData(); 
        assertEquals("Mock Data", result); 
    } 
    
    // Dummy classes added to make it compile-like structurally (optional, but good practice)
    static class ExternalApi {
        public String getData() { return ""; }
    }
    
    static class MyService {
        private ExternalApi api;
        public MyService(ExternalApi api) { this.api = api; }
        public String fetchData() { return api.getData(); }
    }
}
