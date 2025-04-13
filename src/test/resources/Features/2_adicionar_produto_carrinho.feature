@testesWeb
Feature: Adicionar produto ao carrinho

  Scenario: Usuário adiciona um produto ao carrinho com sucesso
    Given que estou logado no e-commerce Swag Labs com username "standard_user" e password "secret_sauce"
    When eu adiciono o produto "Sauce Labs Backpack" ao carrinho
    And eu acesso a página do carrinho
    Then o produto "Sauce Labs Backpack" deve estar visível na página do carrinho
    And o preço do produto no carrinho deve ser "$29.99"
