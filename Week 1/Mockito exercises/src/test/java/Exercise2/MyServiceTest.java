import static org.mockito.Mockito.*; 
import org.junit.jupiter.api.Test; 
import org.mockito.Mockito; 

public class MyServiceTest { 
    @Test 
    public void testVerifyInteraction() { 
        // 1. Create a mock object.
        ExternalApi mockApi = Mockito.mock(ExternalApi.class); 
        
        MyService service = new MyService(mockApi); 
        
        // 2. Call the method with specific arguments.
        service.fetchData(); 
        
        // 3. Verify the interaction.
        verify(mockApi).getData(); 
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
