package br.com.clubprivate.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.clubprivate.daos.UserDAO;
import br.com.clubprivate.models.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.clubprivate.daos.DAO;
import br.com.clubprivate.models.AbstractModel;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.parser.Entity;
import javax.ws.rs.core.Response;

public abstract class AbstractController<T extends AbstractModel, ID> {

    @Autowired
    private DAO<T, ID> dao;
    private Class<T> itemClass;
    private Collection<T> items;

    @Autowired
    private UserDAO userDAO;

    public AbstractController() {
    }

    public AbstractController(Class<T> itemClass) {
        this.itemClass = itemClass;
    }

    //    public Response check(HttpServletRequest request) {
//        String[] token = request.getHeader("x-auth-token").split("_");
//        User usuario = userDAO.find((long)1);
//        if (usuario.getBloqueado()) {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Usuário Bloqueado").build();
//        }
//        return null;
//    }


    @RequestMapping(value = "/",method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<T>> list(HttpServletRequest request) {
//        Response response = check(request);
//        if(response == null){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        List<T> listAll = dao.findAll();
        if (!listAll.isEmpty()) {
            return new ResponseEntity<List<T>>(listAll, responseHeaders,HttpStatus.ACCEPTED); // 200
        } else {
            return new ResponseEntity<List<T>>(listAll, responseHeaders,HttpStatus.NO_CONTENT); // 204
        }
//        }
//        return response;
    }
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.POST)// ,headers="Accept=application/xml, application/json" consumes = "application/json"
//    @ResponseStatus(value = HttpStatus.CREATED) // Como estamos tratando nenhuma exceção aqui, ele por padrão já retorna um status CREATED.
    public  T incluir(@RequestBody T entity) {
    	dao.update(entity);
    	return entity;
    }

    @RequestMapping("/{id}")
    public @ResponseBody T load(@PathVariable ID id) {
        return dao.find(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody T update(@RequestBody T entity) throws IOException {
        dao.update(entity);
        return entity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody ID remove(@PathVariable ID id) throws IOException {
        dao.remove(id);
        return id;
    }

    public T mountMyObject(HttpEntity<String> httpEntity) throws IOException {
        return new ObjectMapper().readValue(httpEntity.getBody(), itemClass);
    }

    public DAO<T, ID> getDao() {
        return dao;
    }
}
