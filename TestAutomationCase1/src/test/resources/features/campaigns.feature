Feature: List all campaigns
  Scenario Outline: User clicks on category and obtains the list of campaigns
    Given user opens the page
    When user clicks on <category>
    Then user sees the <category> campaigns list
    Examples:
      | category                  |
      |  "giyim-ayakkabi"         |
      |  "elektronik"             |
      |  "ev-yasam"               |
      |  "anne-bebek"             |
      |  "kozmetik-kisisel-bakim" |
      |  "mucevher-saat"          |
      |  "spor-outdoor"           |
      |  "kitap-muzik-film-oyun"  |
      |  "tatil-eglence"          |
      |  "otomotiv-motosiklet"    |