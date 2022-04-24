package br.mil.pamerj.projects.telefonia.events
{
	
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	
	public class ItemSelectedEvent extends Event
	{
		public static var ITEM_SELECTED_EVENT:String = "itemSelectedEvent";
		
		
		public var item:Object;
		
		
		public function ItemSelectedEvent(type:String, item:Object)
		{
			super(type, true);
			
			this.item = item;
		}
		override public function clone():Event {
			return new ItemSelectedEvent(type, item);
		}
	}
}