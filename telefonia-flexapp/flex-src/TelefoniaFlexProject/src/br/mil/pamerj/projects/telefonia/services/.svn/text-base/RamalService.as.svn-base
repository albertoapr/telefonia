package br.mil.pamerj.projects.telefonia.services
{
	
	import br.mil.pamerj.projects.telefonia.events.RamalServiceEvent;
	import br.mil.pamerj.projects.telefonia.model.Ramal;
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	[Event(name="ramalLoadedEvent", type="br.mil.pamerj.projects.telefonia.events.RamalServiceEvent")]
	[Event(name="ramaisLoadedEvent", type="br.mil.pamerj.projects.telefonia.events.RamalServiceEvent")]
	[Event(name="ramalRemovedEvent", type="br.mil.pamerj.projects.telefonia.events.RamalServiceEvent")]
	[Event(name="ramalCreatedEvent", type="br.mil.pamerj.projects.telefonia.events.RamalServiceEvent")]
	[Event(name="ramalUpdatedEvent", type="br.mil.pamerj.projects.telefonia.events.RamalServiceEvent")]
	
	
	[Bindable]
	public class RamalService extends RemoteObject
	{
		public function RamalService()
		{
			super("ligacaoServiceDestination");
			this.showBusyCursor = true;
		}
	
		public function call(Method:AsyncToken, NewResult:Function):void{  
			var L_Async:AsyncToken;  
			L_Async = Method;  
			L_Async.addResponder(new Responder(NewResult, DefaultFaultHandler));  
		}  
		public function get getConexao():RemoteObject{  
			return this;  
		}  

		public function findAll():void{
			this.call(this.getConexao.findAllRamais(), findAllResultHandler);
		}
		public function findAllByLogin(login:String):void{
			this.call(this.getConexao.findRamalByLogin(login), findAllResultHandler);
		}
		public function searchByLogin(login:String):void{
			this.call(this.getConexao.searchRamalByLogin(login), findAllResultHandler);
		}
		public function searchByNumero(numero:String):void{
			this.call(this.getConexao.searchRamalByNumero(numero), findAllResultHandler);
		}
		public function create(chave:Ramal):void{
			this.call(this.getConexao.createRamal(chave), createResultHandler);	
			
		}
		public function update(chave:Ramal):void{
			this.call(this.getConexao.updateRamal(chave), updateResultHandler);	
			
		}

		public function find(id:Number):void{
			this.call(this.getConexao.findRamal(id), findResultHandler);
		}
		public function remove(id:Number):void{
			this.call(this.getConexao.removeRamal(id), removeResultHandler);
		}
				
		
		
		/*
		**
		** Handlers
		**
		*/
		
		private function findAllResultHandler(event:ResultEvent):void {
			var chaves:ArrayCollection = event.result as ArrayCollection;
			this.dispatchEvent(
				new RamalServiceEvent(RamalServiceEvent.RAMAIS_LOADED_EVENT, null, chaves));
		}
		private function DefaultFaultHandler(Result:FaultEvent):void{     
			Alert.show(Result.fault.faultString,"Error");  
		} 
		private function createResultHandler(event:ResultEvent):void {
			this.dispatchEvent(
				new RamalServiceEvent(RamalServiceEvent.RAMAL_CREATED_EVENT, null, null));
			
		}
		private function findResultHandler(event:ResultEvent):void {
			var chave:Ramal = event.result as Ramal;
			this.dispatchEvent(
				new RamalServiceEvent(RamalServiceEvent.RAMAL_LOADED_EVENT, chave, null));
			
		}
		private function removeResultHandler(event:ResultEvent):void{
			this.dispatchEvent(
				new RamalServiceEvent(RamalServiceEvent.RAMAL_REMOVED_EVENT, null, null));

		}
		private function updateResultHandler(event:ResultEvent):void{
			this.dispatchEvent(
				new RamalServiceEvent(RamalServiceEvent.RAMAL_UPDATED_EVENT, null, null));

		}

		
	}	
}