job("example2-dsl-job"){
  description("job de prueba dsl")
  scm {
    	git("https://github.com/macloujulian/jenkins.job.parametrizado.git", "main") { node -> 
      		node / gitConfigName('yogui')
      		node / gitConfigEmail('yogui@gmail.com')
	}
  }
  parameters {
  	stringParam('nombre', defaultValue = 'Julian', description = 'Parametro de cadena para el Job Booleano')
    	choiceParam('planeta', ['Mercurio', 'Venus', 'Tierra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
    	booleanParam('agente', false)
  }
  triggers {
    		cron('H/7 * * * *')
  }
  steps {
    		shell("bash jobscript.sh")
  }
  
  publishers {
    mailer('yogui@gmail.com', true, true)
  }
  
}
