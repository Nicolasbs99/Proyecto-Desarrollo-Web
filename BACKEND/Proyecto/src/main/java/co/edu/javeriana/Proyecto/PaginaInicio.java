package co.edu.javeriana.Proyecto;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.edu.javeriana.Proyecto.Model.Monstruo;

@Controller
public class PaginaInicio  {

    @Autowired
    Monstruo m;

    Logger log = LoggerFactory.getLogger(getClass());
    @RequestMapping(path="/Inicio", method = RequestMethod.GET , produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    String Iniciar()
    {
        return "Name: "+m.getNombre()+"   Id: "+m.getId();
    }
}
