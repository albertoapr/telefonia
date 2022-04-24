package br.mil.pamerj.projects.telefonia.services
{
	
	import br.mil.pamerj.projects.telefonia.events.AdminUserServiceEvent;
	import br.mil.pamerj.projects.telefonia.events.PessoaServiceEvent;
	import br.mil.pamerj.projects.telefonia.model.AdminUser;
	import br.mil.pamerj.projects.telefonia.model.Pessoa;
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	[Event(name="userLoadedEvent", type="br.mil.pamerj.projects.telefonia.events.AdminUserServiceEvent")]
	[Event(name="usersLoadedEvent", type="br.mil.pamerj.projects.telefonia.events.AdminUserServiceEvent")]
	[Event(name="userRemovedEvent", type="br.mil.pamerj.projects.telefonia.events.AdminUserServiceEvent")]
	[Event(name="userCreatedEvent", type="br.mil.pamerj.projects.telefonia.events.AdminUserServiceEvent")]
	[Event(name="userUpdatedEvent", type="br.mil.pamerj.projects.telefonia.events.AdminUserServiceEvent")]
	[Event(name="userLoggedEvent", type="br.mil.pamerj.projects.telefonia.events.AdminUserServiceEvent")]
	[Event(name="pessoaLoadedEvent", type="br.mil.pamerj.projects.telefonia.events.PessoaServiceEvent")]
	[Event(name="pessoasLoadedEvent", type="br.mil.pamerj.projects.telefonia.events.PessoaServiceEvent")]
	
	
	[Bindable]
	public class UserService extends RemoteObject
	{
		public function UserService()
		{
			super("userServiceDestination");
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
			this.call(this.getConexao.findAllAdminUsers(), findAllResultHandler);
		}
		public function create(user:AdminUser):void{
			this.call(this.getConexao.createAdminUser(user), createResultHandler);	
			
		}
		public function update(user:AdminUser):void{
			this.call(this.getConexao.updateAdminUser(user), updateResultHandler);	
			
		}

		public function findPessoaByLogin(login:String):void{
			this.call(this.getConexao.findPessoa(login), findPessoaResultHandler);
		}
		
		public function find(id:Number):void{
			this.call(this.getConexao.findAdminUser(id), findResultHandler);
		}
		public function findByLogin(login:String):void{
			this.call(this.getConexao.findAdminUser(login), findResultHandler);
		}
		public function remove(id:Number):void{
			this.call(this.getConexao.removeAdminUser(id), removeResultHandler);
		}
				
		public function authenticate(login:String, password:String):void{
			this.call(this.getConexao.login(login, password), loginResultHandler);
		}
		
		/*
		**
		** Handlers
		**
		*/
		
		private function findAllResultHandler(event:ResultEvent):void {
			var users:ArrayCollection = event.result as ArrayCollection;
			this.dispatchEvent(
				new AdminUserServiceEvent(AdminUserServiceEvent.USERS_LOADED_EVENT, null, users));
		}
		private function DefaultFaultHandler(Result:FaultEvent):void{     
			Alert.show(Result.fault.faultString,"Error");  
		} 
		private function createResultHandler(event:ResultEvent):void {
			this.dispatchEvent(
				new AdminUserServiceEvent(AdminUserServiceEvent.USER_CREATED_EVENT, null, null));
			
		}
		private function findResultHandler(event:ResultEvent):void {
			var user:AdminUser = event.result as AdminUser;
			this.dispatchEvent(
				new AdminUserServiceEvent(AdminUserServiceEvent.USER_LOADED_EVENT, user, null));
			
		}
		private function findPessoaResultHandler(event:ResultEvent):void {
			var pessoa:Pessoa = event.result as Pessoa;
			this.dispatchEvent(
				new PessoaServiceEvent(PessoaServiceEvent.PESSOA_LOADED_EVENT, pessoa, null));
			
		}
		private function removeResultHandler(event:ResultEvent):void{
			this.dispatchEvent(
				new AdminUserServiceEvent(AdminUserServiceEvent.USER_REMOVED_EVENT, null, null));

		}
		private function updateResultHandler(event:ResultEvent):void{
			this.dispatchEvent(
				new AdminUserServiceEvent(AdminUserServiceEvent.USER_UPDATED_EVENT, null, null));

		}
		private function loginResultHandler(event:ResultEvent):void{
			
			if(event.result == true){
			this.dispatchEvent(
				new AdminUserServiceEvent(AdminUserServiceEvent.USER_LOGGED_EVENT, null, null));
			
			}else{
				Alert.show("Login ou senha inválidos! Por favor, tente novamente.")
			}
		}

		
	}	
}