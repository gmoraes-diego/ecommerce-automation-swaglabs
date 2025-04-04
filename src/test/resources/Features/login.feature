@testesWeb
Feature: Login com sucesso no SauceDemo

  Scenario: Login com sucesso
    Given que eu estou na página de login do SauceDemo
    When preencho os campos Username e Password
    And clico em Login
    Then devo ser redirecionado para página de produtos
    And devo visualizar o título da página



