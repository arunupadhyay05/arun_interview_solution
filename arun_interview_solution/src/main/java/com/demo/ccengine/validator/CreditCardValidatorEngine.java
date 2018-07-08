package com.demo.ccengine.validator;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.demo.ccengine.service.CreditCard;

@Component
public class CreditCardValidatorEngine {
	
	private ExecutorService executorService;
	
	@PostConstruct
	public void init(){
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());		
	}
	
	
	public Future<Set<CreditCard>> addCardsForValidation(final Set<CreditCard> cards, final CardValidator cardValidator){
		synchronized (this) {		
			return executorService.submit(new CreditCardValidatorWorkerTask(cards, cardValidator));
		}
	}
	
	
	
	@PreDestroy
	public void destroy(){
		executorService.shutdown();
	}

}
