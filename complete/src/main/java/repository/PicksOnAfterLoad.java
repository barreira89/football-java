package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterLoadEvent;

public class PicksOnAfterLoad extends AbstractMongoEventListener<Object> {
	
	@Autowired
	private MongoOperations mongoOperations;
	
	@Override
	public void onAfterLoad(AfterLoadEvent event){
		//System.out.println("TEST" + event.toString());
		
	}
	
	@Override
	public void onBeforeConvert(Object o){
		//System.out.print("TEST before convert" + o);
	}

}
