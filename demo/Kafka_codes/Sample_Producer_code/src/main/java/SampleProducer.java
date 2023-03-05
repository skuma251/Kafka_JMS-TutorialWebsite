
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class SampleProducer {
    public SampleProducer(){
        Properties properties=new Properties();
        properties.put("bootstrap.servers","localhost:9092");
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        ProducerRecord producerRecord=new ProducerRecord("seattle","name","portland");
        ProducerRecord producerRecord2=new ProducerRecord("seattle","name","bellueve");
        ProducerRecord producerRecord3=new ProducerRecord("seattle","name","Casino");

        KafkaProducer KafkaProducer=new KafkaProducer(properties);
        KafkaProducer.send(producerRecord);
        KafkaProducer.send(producerRecord2);
        KafkaProducer.send(producerRecord3);

        KafkaProducer.close();


    }
}
