package br.mil.pamerj.projects.telefonia.services
{
	
	import br.mil.pamerj.projects.telefonia.events.FaturaServiceEvent;
	import br.mil.pamerj.projects.telefonia.model.Fatura;
	import br.mil.pamerj.projects.telefonia.model.ItemFatura;
	
	import flash.events.Event;
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	[Event(name="faturaLoadedEvent", type="br.mil.pamerj.projects.telefonia.events.FaturaServiceEvent")]
	[Event(name="faturasLoadedEvent", type="br.mil.pamerj.projects.telefonia.events.FaturaServiceEvent")]
	[Event(name="faturaRemovedEvent", type="br.mil.pamerj.projects.telefonia.events.FaturaServiceEvent")]
	[Event(name="faturaCreatedEvent", type="br.mil.pamerj.projects.telefonia.events.FaturaServiceEvent")]
	[Event(name="faturaUpdatedEvent", type="br.mil.pamerj.projects.telefonia.events.FaturaServiceEvent")]
	
	
	[Bindable]
	public class FaturaService extends RemoteObject
	{
		public function FaturaService()
		{
			super("faturaServiceDestination");
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
			this.call(this.getConexao.findAllFaturas(), findAllResultHandler);
		}
		public function findAllByPeriodo(periodo:Date):void{
			this.call(this.getConexao.findAllFaturas(periodo), findAllResultHandler);
		}
		public function findAllByPeriodoAndStatus(periodo:Date, aberto:Boolean):void{
			this.call(this.getConexao.findAllFaturas(periodo, aberto), findAllResultHandler);
		}
		public function findAllByLogin(login:String):void{
			this.call(this.getConexao.findFaturasByLogin(login), findAllResultHandler);
		}
		public function create(fatura:Fatura, file:ByteArray):void{
			
			this.call(this.getConexao.createFatura(fatura, file), createResultHandler);	
			
		}
		public function update(fatura:Fatura):void{
			this.call(this.getConexao.updateFatura(fatura), updateResultHandler);	
			
		}

		public function find(id:Number):void{
			this.call(this.getConexao.findFatura(id), findResultHandler);
		}
		public function remove(id:Number):void{
			this.call(this.getConexao.removeFatura(id), removeResultHandler);
		}
				
		
		
		/*
		**
		** Handlers
		**
		*/
		
		private function findAllResultHandler(event:ResultEvent):void {
			var faturas:ArrayCollection = event.result as ArrayCollection;
			this.dispatchEvent(
				new FaturaServiceEvent(FaturaServiceEvent.FATURAS_LOADED_EVENT, null, faturas));
		}
		private function DefaultFaultHandler(Result:FaultEvent):void{     
			Alert.show(Result.fault.faultString,"Error");  
		} 
		private function createResultHandler(event:ResultEvent):void {
			this.dispatchEvent(
				new FaturaServiceEvent(FaturaServiceEvent.FATURA_CREATED_EVENT, null, null));
			
		}
		private function findResultHandler(event:ResultEvent):void {
			var fatura:Fatura = event.result as Fatura;
			
			this.dispatchEvent(
				new FaturaServiceEvent(FaturaServiceEvent.FATURA_LOADED_EVENT, fatura, null));
			
		}
		private function removeResultHandler(event:ResultEvent):void{
			this.dispatchEvent(
				new FaturaServiceEvent(FaturaServiceEvent.FATURA_REMOVED_EVENT, null, null));

		}
		private function updateResultHandler(event:ResultEvent):void{
			this.dispatchEvent(
				new FaturaServiceEvent(FaturaServiceEvent.FATURA_UPDATED_EVENT, null, null));

		}

		
	}	
}