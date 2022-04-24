package br.mil.pamerj.projects.telefonia.model
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="mil.br.pamerj.projects.telefonia.dto.AdminUserDTO")]
	public class AdminUser
	{
		public var id:Number;
		public var login:String;
		
		public function AdminUser()
		{
		}
	}
}