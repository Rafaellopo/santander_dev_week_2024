package me.dio.santander_dev_week_2024.controller.dto;

import static java.util.Collections.emptyList;
import java.util.List;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

import me.dio.santander_dev_week_2024.domain.model.Users;

public record UserDto(
    Long id,
    String name,
    AccountDto account,
    CardDto card,
    List<FeatureDto> features,
    List<NewsDto> news) {

public UserDto(Users model) {
    this(
            model.getId(),
            model.getName(),
            ofNullable(model.getAccount()).map(AccountDto::new).orElse(null),
            ofNullable(model.getCard()).map(CardDto::new).orElse(null),
            ofNullable(model.getFeatures()).orElse(emptyList()).stream().map(FeatureDto::new).collect(toList()),
            ofNullable(model.getNews()).orElse(emptyList()).stream().map(NewsDto::new).collect(toList())
    );
}

public Users toModel() {
    Users model = new Users();
    model.setId(this.id);
    model.setName(this.name);
    model.setAccount(ofNullable(this.account).map(AccountDto::toModel).orElse(null));
    model.setCard(ofNullable(this.card).map(CardDto::toModel).orElse(null));
    model.setFeatures(ofNullable(this.features).orElse(emptyList()).stream().map(FeatureDto::toModel).collect(toList()));
    model.setNews(ofNullable(this.news).orElse(emptyList()).stream().map(NewsDto::toModel).collect(toList()));
    return model;
}

}
