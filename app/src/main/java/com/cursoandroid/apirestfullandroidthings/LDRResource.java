package com.cursoandroid.apirestfullandroidthings;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Options;
import org.restlet.resource.ServerResource;

import java.util.HashSet;
import java.util.Set;

public class LDRResource extends ServerResource {

    private final String TAG = LDRResource.class.getCanonicalName();

    @Get("json")
    public Representation getValue() {
        Log.d(TAG, "json call getValue()");
        JSONObject result = new JSONObject();
        try {
            result.put("value", LDRmodel.getValue());
        } catch (Exception e) {
            Log.e(TAG, "Error en JSONObject: ", e);
        }
        getResponse().setAccessControlAllowOrigin("*");
        return new StringRepresentation(result.toString(), MediaType.APPLICATION_ALL_JSON);
    }

    @Options
    public void getCorsSupport() {
        Set<String> head = new HashSet<>();
        head.add("X-Requested-With");
        head.add("Content-Type");
        head.add("Accept");
        getResponse().setAccessControlAllowHeaders(head);
        Set<Method> methods = new HashSet<>();
        methods.add(Method.GET);
        methods.add(Method.OPTIONS);
        getResponse().setAccessControlAllowMethods(methods);
        getResponse().setAccessControlAllowOrigin("*");
    }

}
