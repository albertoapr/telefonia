package br.mil.pamerj.projects.telefonia.services
{
	
	import br.mil.pamerj.projects.telefonia.events.LigacaoServiceEvent;
	import br.mil.pamerj.projects.telefonia.model.Ligacao;
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	[Event(name="ligacaoLoadedEvent", type="br.mil.pamerj.projects.telefonia.events.LigacaoServiceEvent")]
	[Event(name="ligacoesLoadedEvent", type="br.mil.pamerj.projects.telefonia.events.LigacaoServiceEvent")]
	[Event(name="ligacaoRemovedEvent", type="br.mil.pamerj.projects.telefonia.events.LigacaoServiceEvent")]
	[Event(name="ligacaoCreatedEvent", type="br.mil.pamerj.projects.telefonia.events.LigacaoServiceEvent")]
	[Event(name="ligacaoUpdatedEvent", type="br.mil.pamerj.projects.telefonia.events.LigacaoServiceEvent")]
	
	
	[Bindable]
	public class LigacaoService extends RemoteObject
	{
		public function LigacaoService()
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
			this.call(this.getConexao.findAllLigacoes(), findAllResultHandler);
		}
		public function findAllByLogin(login:String, mes:Date):void{
			this.call(this.getConexao.findAllLigacoes(login, mes), findAllResultHandler);
		}
		
		public function create(ligacao:Ligacao):void{
			this.call(this.getConexao.createLigacao(ligacao), createResultHandler);	
			
		}
		public function update(ligacao:Ligacao):void{
			this.call(this.getConexao.updateLigacao(ligacao), updateResultHandler);	
			
		}

		public function find(id:Number):void{
			this.call(this.getConexao.findLigacao(id), findResultHandler);
		}
		public function remove(id:Number):void{
			this.call(this.getConexao.removeLigacao(id), removeResultHandler);
		}
				
		
		
		/*
		**
		** Handlers
		**
		*/
		
		private function findAllResultHandler(event:ResultEvent):void {
			var ligacoes:ArrayCollection = event.result as ArrayCollection;
			this.dispatchEvent(
				new LigacaoServiceEvent(LigacaoServiceEvent.LIGACOES_LOADED_EVENT, null, ligacoes));
		}
		private function DefaultFaultHandler(Result:FaultEvent):void{     
			Alert.show(Result.fault.faultString,"Error");  
		} 
		private function createResultHandler(event:ResultEvent):void {
			this.dispatchEvent(
				new LigacaoServiceEvent(LigacaoServiceEvent.LIGACAO_CREATED_EVENT, null, null));
			
		}
		private function findResultHandler(event:ResultEvent):void {
			var ligacao:Ligacao = event.result as Ligacao;
			this.dispatchEvent(
				new LigacaoServiceEvent(LigacaoServiceEvent.LIGACAO_LOADED_EVENT, ligacao, null));
			
		}
		private function removeResultHandler(event:ResultEvent):void{
			this.dispatchEvent(
				new LigacaoServiceEvent(LigacaoServiceEvent.LIGACAO_REMOVED_EVENT, null, null));

		}
		private function updateResultHandler(event:ResultEvent):void{
			this.dispatchEvent(
				new LigacaoServiceEvent(LigacaoServiceEvent.LIGACAO_UPDATED_EVENT, null, null));

		}

		
	}	
}