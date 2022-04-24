package br.mil.pamerj.projects.telefonia.model
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="mil.br.pamerj.projects.telefonia.dto.LigacaoDTO")]
	public class Ligacao
	{
		
		public var id:Number;
		public var numero:String;
		public var dataHora:Date;
		public var duracao:Date;
		public var custo:Number;
		public var local:String;
		public var tipo:String;
		
		public var ramal:Ramal = new Ramal();
	
		
		public function Ligacao()
		{
		}
	}
}