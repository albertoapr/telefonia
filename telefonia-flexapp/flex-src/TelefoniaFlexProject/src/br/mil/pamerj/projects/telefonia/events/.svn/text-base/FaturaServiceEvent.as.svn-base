package br.mil.pamerj.projects.telefonia.events
{
	import br.mil.pamerj.projects.telefonia.model.Fatura
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	
	public class FaturaServiceEvent extends Event
	{
		public static var FATURA_LOADED_EVENT:String = "faturaLoadedEvent";
		public static var FATURAS_LOADED_EVENT:String = "faturasLoadedEvent";
		public static var FATURA_REMOVED_EVENT:String = "faturaRemovedEvent";
		public static var FATURA_CREATED_EVENT:String = "faturaCreatedEvent";
		public static var FATURA_UPDATED_EVENT:String = "faturaUpdatedEvent";
		
		
		public var fatura:Fatura;
		public var faturas:ArrayCollection;
		
		public function FaturaServiceEvent(type:String, fatura:Fatura, faturas:ArrayCollection)
		{
			super(type, true);
			this.fatura = fatura;
			this.faturas = faturas;
		}
		override public function clone():Event {
			return new FaturaServiceEvent(type, fatura, faturas);
		}
	}
}