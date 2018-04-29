import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.Mongo;

import java.net.UnknownHostException;

@Configuration
@EnableMongoRepositories(basePackages = "orders.db")
public class MongoCilient {

//    @Bean
//    public MongoFactoryBean mongo() {
//        MongoFactoryBean mongo = new MongoFactoryBean();
//        mongo.setHost("localhost");
//        return mongo;
//    }

    @Bean
    public MongoClient mongo() throws UnknownHostException {
        MongoClient mongo = new MongoClient("localhost");
        return mongo;
    }

    @Bean
    public MongoOperations mongoTemaplete(Mongo mongo){
        return new MongoTemplate(mongo, "OrdersDB");
    }
}
