package br.mil.pamerj.projects.telefonia.services
{
	
	import br.mil.pamerj.projects.telefonia.events.FaturamentoServiceEvent;
	import br.mil.pamerj.projects.telefonia.model.Faturamento;
	
	import flash.events.Event;
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	[Event(name="faturamentoLoadedEvent", type="br.mil.pamerj.projects.telefonia.events.FaturamentoServiceEvent")]
	[Event(name="faturamentosLoadedEvent", type="br.mil.pamerj.projects.telefonia.events.FaturamentoServiceEvent")]
	[Event(name="faturamentoRemovedEvent", type="br.mil.pamerj.projects.telefonia.events.FaturamentoServiceEvent")]
	[Event(name="faturamentoCreatedEvent", type="br.mil.pamerj.projects.telefonia.events.FaturamentoServiceEvent")]
	[Event(name="faturamentoUpdatedEvent", type="br.mil.pamerj.projects.telefonia.events.FaturamentoServiceEvent")]
	
	
	[Bindable]
	public class FaturamentoService extends RemoteObject
	{
		public function FaturamentoService()
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
			this.call(this.getConexao.findAllFaturamentos(), findAllResultHandler);
		}
		public function create(chave:Faturamento, file:ByteArray):void{
			
			this.call(this.getConexao.createFaturamento(chave, file), createResultHandler);	
			
		}
		public function update(chave:Faturamento):void{
			this.call(this.getConexao.updateFaturamento(chave), updateResultHandler);	
			
		}

		public function find(id:Number):void{
			this.call(this.getConexao.findFaturamento(id), findResultHandler);
		}
		public function remove(id:Number):void{
			this.call(this.getConexao.removeFaturamento(id), removeResultHandler);
		}
				
		
		
		/*
		**
		** Handlers
		**
		*/
		
		private function findAllResultHandler(event:ResultEvent):void {
			var faturamentos:ArrayCollection = event.result as ArrayCollection;
			this.dispatchEvent(
				new FaturamentoServiceEvent(FaturamentoServiceEvent.FATURAMENTOS_LOADED_EVENT, null, faturamentos));
		}
		private function DefaultFaultHandler(Result:FaultEvent):void{     
			Alert.show(Result.fault.faultString,"Error");  
		} 
		private function createResultHandler(event:ResultEvent):void {
			this.dispatchEvent(
				new FaturamentoServiceEvent(FaturamentoServiceEvent.FATURAMENTO_CREATED_EVENT, null, null));
			
		}
		private function findResultHandler(event:ResultEvent):void {
			var chave:Faturamento = event.result as Faturamento;
			this.dispatchEvent(
				new FaturamentoServiceEvent(FaturamentoServiceEvent.FATURAMENTO_LOADED_EVENT, chave, null));
			
		}
		private function removeResultHandler(event:ResultEvent):void{
			this.dispatchEvent(
				new FaturamentoServiceEvent(FaturamentoServiceEvent.FATURAMENTO_REMOVED_EVENT, null, null));

		}
		private function updateResultHandler(event:ResultEvent):void{
			this.dispatchEvent(
				new FaturamentoServiceEvent(FaturamentoServiceEvent.FATURAMENTO_UPDATED_EVENT, null, null));

		}

		
	}	
}