package br.mil.pamerj.projects.telefonia.events
{
	
	
	import flash.events.Event;
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	
	
	public class RelatorioServiceEvent extends Event
	{
		public static var RELATORIO_GENERATED_EVENT:String = "relatorioGeneratedEvent";
		
		
		public var relatorio:ByteArray;
		
		
		public function RelatorioServiceEvent(type:String, relatorio:ByteArray)
		{
			super(type, true);
			
			this.relatorio = relatorio;
		}
		override public function clone():Event {
			return new RelatorioServiceEvent(type, relatorio);
		}
	}
}