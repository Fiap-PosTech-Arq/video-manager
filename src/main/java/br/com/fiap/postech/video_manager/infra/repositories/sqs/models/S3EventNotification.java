package br.com.fiap.postech.video_manager.infra.repositories.sqs.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
public class S3EventNotification {

    @JsonProperty("Records")
    private List<Record> records;

    public S3EventNotification() {
        this.records = new ArrayList<>();
    }
}
