package TwitterCloneBackend.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserAccountRepositoryTest {

    @BeforeEach
    @AfterEach
    public void clearDatabase() {
        

    }
    @Test
    public void testPersistAndLoadAccount() {

    }
}
