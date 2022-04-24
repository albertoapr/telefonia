package br.mil.pamerj.projects.telefonia.events
{
	import br.mil.pamerj.projects.telefonia.model.Ramal
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	
	public class RamalServiceEvent extends Event
	{
		public static var RAMAL_LOADED_EVENT:String = "ramalLoadedEvent";
		public static var RAMAIS_LOADED_EVENT:String = "ramaisLoadedEvent";
		public static var RAMAL_REMOVED_EVENT:String = "ramalRemovedEvent";
		public static var RAMAL_CREATED_EVENT:String = "ramalCreatedEvent";
		public static var RAMAL_UPDATED_EVENT:String = "ramalUpdatedEvent";
		
		
		public var ramal:Ramal;
		public var ramais:ArrayCollection;
		
		public function RamalServiceEvent(type:String, ramal:Ramal, ramais:ArrayCollection)
		{
			super(type, true);
			this.ramal = ramal;
			this.ramais = ramais;
		}
		override public function clone():Event {
			return new RamalServiceEvent(type, ramal, ramais);
		}
	}
}