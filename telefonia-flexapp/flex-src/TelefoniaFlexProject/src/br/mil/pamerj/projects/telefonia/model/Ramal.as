package br.mil.pamerj.projects.telefonia.model
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="mil.br.pamerj.projects.telefonia.dto.RamalDTO")]
	public class Ramal
	{
		public var id:Number;
		public var numero:String;
		public var login:String;
		public var descricao:String;
		public var ligacoes:ArrayCollection = new ArrayCollection();
		public var faturas:ArrayCollection = new ArrayCollection();
		
		public function Ramal()
		{
		}
	}
}