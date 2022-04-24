package br.mil.pamerj.projects.telefonia.events
{
	import br.mil.pamerj.projects.telefonia.model.AdminUser;
	import br.mil.pamerj.projects.telefonia.model.Ramal;
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	
	public class AdminUserServiceEvent extends Event
	{
		public static var USER_LOADED_EVENT:String = "userLoadedEvent";
		public static var USERS_LOADED_EVENT:String = "usersLoadedEvent";
		public static var USER_REMOVED_EVENT:String = "userRemovedEvent";
		public static var USER_CREATED_EVENT:String = "userCreatedEvent";
		public static var USER_UPDATED_EVENT:String = "userUpdatedEvent";
		public static var USER_LOGGED_EVENT:String = "userLoggedEvent";
		
		
		public var user:AdminUser;
		public var users:ArrayCollection;
		
		public function AdminUserServiceEvent(type:String, user:AdminUser, users:ArrayCollection)
		{
			super(type, true);
			this.user = user;
			this.users = users;
		}
		override public function clone():Event {
			return new AdminUserServiceEvent(type, user, users);
		}
	}
}