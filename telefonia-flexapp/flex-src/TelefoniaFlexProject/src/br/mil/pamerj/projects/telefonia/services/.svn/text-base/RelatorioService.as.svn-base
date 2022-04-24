package br.mil.pamerj.projects.telefonia.services
{
	
	
	import br.mil.pamerj.projects.telefonia.events.RelatorioServiceEvent;
	import br.mil.pamerj.projects.telefonia.model.Fatura;
	
	import flash.events.Event;
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	[Event(name="relatorioGeneratedEvent", type="br.mil.pamerj.projects.telefonia.events.RelatorioServiceEvent")]
	
	
	[Bindable]
	public class RelatorioService extends RemoteObject
	{
		public function RelatorioService()
		{
			super("relatorioServiceDestination");
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

		public function gerarFatura(fatura:Fatura):void{
			this.call(this.getConexao.gerarFaturaPDF(fatura), relatorioGeneratedResultHandler);
		}

		public function gerarRelatorioFaturas(faturas:ArrayCollection):void{
			this.call(this.getConexao.gerarRelatorioFaturasPDF(faturas), relatorioGeneratedResultHandler);
		}
		
		/*
		**
		** Handlers
		**
		*/
		
		private function relatorioGeneratedResultHandler(event:ResultEvent):void {
			var relatorio:ByteArray = event.result as ByteArray; 
			this.dispatchEvent(
				new RelatorioServiceEvent(RelatorioServiceEvent.RELATORIO_GENERATED_EVENT,relatorio ));
		}
		private function DefaultFaultHandler(Result:FaultEvent):void{     
			Alert.show(Result.fault.faultString,"Error");  
		} 

		
	}	
}