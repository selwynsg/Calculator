1. https://github.com/selwynsg/Calculator.git
2. press play and click which design pattern you want to use.

Brief description:
Project that is split into two design patterns, the MVVM and the MVP. In the Model View ViewModel
implementation, the view gets all the information from the ViewModels' livedata field (which is immutable)
and will print it out on its own. In this case, the ViewModel has no communication with the View and 
thus is not coupled/dependent on the view. 

On the other hand, in the Model View Presenter implementation, the view and the presenter are dependent 
on each other because the view and presenter are directly communicating with each other. In this sense
the MVVM model is better.  