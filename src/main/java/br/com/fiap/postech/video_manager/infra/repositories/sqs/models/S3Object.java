package br.com.fiap.postech.video_manager.infra.repositories.sqs.models;

public record S3Object(String key, long size, String eTag, String sequencer) {}

