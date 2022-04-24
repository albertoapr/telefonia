package br.mil.pamerj.projects.telefonia.events
{
	import br.mil.pamerj.projects.telefonia.model.Faturamento
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	
	public class FaturamentoServiceEvent extends Event
	{
		public static var FATURAMENTO_LOADED_EVENT:String = "faturamentoLoadedEvent";
		public static var FATURAMENTOS_LOADED_EVENT:String = "faturamentosLoadedEvent";
		public static var FATURAMENTO_REMOVED_EVENT:String = "faturamentoRemovedEvent";
		public static var FATURAMENTO_CREATED_EVENT:String = "faturamentoCreatedEvent";
		public static var FATURAMENTO_UPDATED_EVENT:String = "faturamentoUpdatedEvent";
		
		
		public var faturamento:Faturamento;
		public var faturamentos:ArrayCollection;
		
		public function FaturamentoServiceEvent(type:String, faturamento:Faturamento, faturamentos:ArrayCollection)
		{
			super(type, true);
			this.faturamento = faturamento;
			this.faturamentos = faturamentos;
		}
		override public function clone():Event {
			return new FaturamentoServiceEvent(type, faturamento, faturamentos);
		}
	}
}