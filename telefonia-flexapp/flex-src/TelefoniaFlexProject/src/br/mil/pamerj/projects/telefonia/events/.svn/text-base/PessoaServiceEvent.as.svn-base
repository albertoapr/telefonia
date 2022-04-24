package br.mil.pamerj.projects.telefonia.events
{

	import br.mil.pamerj.projects.telefonia.model.Pessoa;
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	
	public class PessoaServiceEvent extends Event
	{
		public static var PESSOA_LOADED_EVENT:String = "pessoaLoadedEvent";
		public static var PESSOAS_LOADED_EVENT:String = "pessoasLoadedEvent";
		
		
		
		public var pessoa:Pessoa;
		public var pessoas:ArrayCollection;
		
		public function PessoaServiceEvent(type:String, pessoa:Pessoa, pessoas:ArrayCollection)
		{
			super(type, true);
			this.pessoa = pessoa;
			this.pessoas = pessoas;
		}
		override public function clone():Event {
			return new PessoaServiceEvent(type, pessoa, pessoas);
		}
	}
}