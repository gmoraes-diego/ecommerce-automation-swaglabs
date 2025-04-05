@testesWeb
Feature: Login com sucesso no SauceDemo

  Scenario: Login com sucesso
    Given que eu estou na página de login do e-commerce Swag Labs
    When preencho os campos com username "standard_user" e password "secret_sauce"
    And clico em Login
    Then devo ser redirecionado para página de produtos
    And devo visualizar o título da página
