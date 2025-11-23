[#ftl]
[@c.page]
    <div class="detail" novalidate>

        [#if vizitka.id??]
            [@form.form class="vizitka" bind="vizitka" action="/upravit/${vizitka.id}" method="post"]
            [@form.input name="celeJmeno" label="Celé jméno" maxlength="100" /]
            [@form.input name="firma" label="Firma" maxlength="100" /]
            [@form.input name="ulice" label="Ulice a čísla" maxlength="100"  /]
            [@form.input name="obec" label="Obec" maxlength="100"  /]
            [@form.input name="psc" label="PSČ" minlength="5" maxlength="5" pattern="[0-9]{5}"  /]
            [@form.input name="email" label="E-mail *" maxlength="100"  type="email" /]
            [@form.input name="telefon" label="Telefon *" maxlength="100"  type="tel" /]
            [@form.input name="web" label="Web *" maxlength="100" pattern="www\\..+" /]
            <div class="form-controls">
                <button type="submit">Odeslat</button>
            </div>
            [/@form.form]
        [#else]
            [@form.form class="vizitka" bind="vizitka" action="/nova" method="post"]
                [@form.input name="celeJmeno" label="Celé jméno" maxlength="100"  /]
                [@form.input name="firma" label="Firma" maxlength="100"  /]
                [@form.input name="ulice" label="Ulice a čísla" maxlength="100"  /]
                [@form.input name="obec" label="Obec" maxlength="100"  /]
                [@form.input name="psc" label="PSČ" minlength="5" maxlength="5" pattern="[0-9]{5}"  /]
                [@form.input name="email" label="E-mail *" maxlength="100"  type="email" /]
                [@form.input name="telefon" label="Telefon *" maxlength="100"  type="tel" /]
                [@form.input name="web" label="Web *" maxlength="100" pattern="www\\..+" /]
                <div class="form-controls">
                    <button type="submit">Odeslat</button>
                </div>
            [/@form.form]
        [/#if]



        [@c.back /]
    </div>
[/@c.page]
