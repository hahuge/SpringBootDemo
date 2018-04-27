package com.hahuge.controller;

import com.hahuge.model.ResponseEntity;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
public class EsTest {

    @Resource
    private TransportClient client;

    @RequestMapping("getes")
    public ResponseEntity getEs(String id){
        if(id == ""){
            id = "1";
        }
        GetResponse response = this.client.prepareGet("book","novel",id).get();
        if(!response.isExists()){
            return new ResponseEntity("err");
        }
        return new ResponseEntity(response);
    }

    @RequestMapping("setes")
    public ResponseEntity setEs(){
        try {
            XContentBuilder content = XContentFactory.jsonBuilder().startObject()
                    .field("title","微首页")
                    .field("author","qq")
                    .field("word_count",1)
                    .field("publish_data","2014-12-11 00:00:00")
                    .endObject();
            IndexResponse response = this.client.prepareIndex("book","novel",Integer.toString(1)).setSource(content).get();
            return new ResponseEntity(response);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity("err");
        }
    }

    @RequestMapping("deles")
    public ResponseEntity deles(String id){
        DeleteResponse response = this.client.prepareDelete("book","novel",id).get();
        return new ResponseEntity(response);
    }

    @RequestMapping("updatees")
    public ResponseEntity updatees(String id){
        String author = "";
        String word_count = "";
        String publish_data = "";
        UpdateRequest update = new UpdateRequest("book","novel",id);
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
                if(author != ""){
                    builder.field("author",author);
                }
                if(word_count != null){
                    builder.field("word_count",word_count);
                }
                if(word_count != null){
                    builder.field("publish_data",publish_data);
                }
                builder.endObject();
                update.doc(builder);

        } catch (IOException e){
            e.printStackTrace();
        }
        try {
            UpdateResponse response = this.client.update(update).get();
            return new ResponseEntity(response.getResult().toString());
        } catch (Exception e) {
            return new ResponseEntity("err");
        }
    }
}
