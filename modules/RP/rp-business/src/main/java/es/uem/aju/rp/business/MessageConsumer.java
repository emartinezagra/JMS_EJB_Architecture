package es.uem.aju.rp.business;

import java.sql.SQLException;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.jboss.annotation.ejb.ResourceAdapter;

import es.uem.aju.common.dao.ActivityDAOMySQL;
import es.uem.aju.common.dao.factory.ActivityDAOFactory;
import es.uem.aju.common.dao.factory.DatasourceMySQLFactory;
import es.uem.aju.common.dto.ActivityDTO;

@MessageDriven(activationConfig =
{
@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
@ActivationConfigProperty(propertyName="destination", propertyValue="ajuQueue"),
@ActivationConfigProperty(propertyName="acknowledgeMode", propertyValue="Auto-acknowledge")
})
@ResourceAdapter("activemq-ra.rar")
public class MessageConsumer implements MessageListener {

	protected static Logger log = Logger.getLogger( MessageConsumer.class );
	private ActivityDAOMySQL activityDAO;
		
	public MessageConsumer(){
	
		ActivityDAOFactory daoFactory = new ActivityDAOFactory();
		activityDAO = daoFactory.getDAO(DatasourceMySQLFactory.MY_SQL);
	}
	
	public void onMessage(Message msg) {
		if (msg instanceof TextMessage){
			log.info("Text Message received");
			TextMessage textMessage = (TextMessage)msg;
			String[] content;
			try {
				content = textMessage.getText().split(",");
			} catch (JMSException e) {
				log.error("Error parsing text message: "+e.getMessage());
				return;
			}
			int userId = Integer.parseInt(content[0]);
			int equipmentId = Integer.parseInt(content[1]);
			boolean entering = Boolean.parseBoolean(content[2]);
			
			ActivityDTO activity = new ActivityDTO(0, userId, equipmentId, null, entering);
			try {
				activityDAO.store(activity);
			} catch (SQLException e) {
				log.error("Error storing activity: "+e.getMessage());
			}
			
		}

	}
}
