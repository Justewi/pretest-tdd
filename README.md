# Alexandre BAR 

I made some choices that I explain below.


## Account : 

I consider that an account cannot be an admin/vendor since the
exercice is only about balances etc... 

Here, I would have requested a Business Analyst / Product Owner assistance to know if
the account could be an admin in the future. But here I am alone so I decide to
think the code so that he can handle this easily but I wont implement it yet. 

I learned with experience that there is no point in preparing complex patterns and architecture
to facilitate an upgrade that will probably never happen. **(YAGNI)**

If an accounts could be admin's (or vendor), I would have taken away all
methods relative to balances since admin account most likely doesnt need those.
Plus, I would have also most likely made Account an abstract class containing common infos
(such as email, password etc.) and methods (login etc.)

Making Account an interface makes it possible to have a contract for different types of customer accounts (such as a premium customer that can withdraw more money that he has on his account eg.)


## AccountRule : 

I added a rule for adding in case of some specific type of accounts (Some accounts could be allowed to Add at most 50 euros eg.)
