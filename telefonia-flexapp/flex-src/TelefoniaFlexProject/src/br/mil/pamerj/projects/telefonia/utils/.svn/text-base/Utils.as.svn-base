package br.mil.pamerj.projects.telefonia.utils
{
	import br.mil.pamerj.projects.telefonia.components.Hiddenable;
	
	import mx.containers.Accordion;
	import mx.core.UIComponent;
	
	public class Utils
	{
		public function Utils()
		{
		}
		public static function hideComponent(component:Hiddenable):void{
			
			(component as UIComponent).visible = false;
			(component as UIComponent).height = 0;
			(component as UIComponent).width = 0;
		}
		public static function showComponent(component:Hiddenable):void{
			
			(component as UIComponent).visible = true;
			if (component is Accordion){
				(component as UIComponent).percentHeight = component.defaultHeight;
			}else{
				(component as UIComponent).height = component.defaultHeight;
			}
			 
			(component as UIComponent).width = component.defaultWidth;
		}
		
	}
}