package es.uem.aju.customer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

public class Sender {

	private ConnectionFactory factory = null;
	private Connection connection = null;
	private Session session = null;
	private Destination destination = null;
	private MessageProducer producer = null;

	protected static Logger log = Logger.getLogger(Sender.class);

	public Sender() {
		factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
	}

	public boolean sendMessageToQueue(String messageContent) {

		try {
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("ajuQueue");
			producer = session.createProducer(destination);
			TextMessage message = session.createTextMessage();
			message.setText(messageContent);
			producer.send(message);
			log.info("Sent: " + message.getText());
			return true;
		} catch (JMSException e) {
			log.error(e);
			return false;
		} finally {
			try {
				if (producer != null) {
					producer.close();
				}
				if (session != null) {
					session.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (JMSException e) {
				log.error("Error cerrando la conexion: " + e.getMessage());
			}
		}
	}
}