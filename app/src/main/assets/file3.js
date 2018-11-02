function saveId(_id)
{
    localStorage.setItem("id", _id);
    Android.nextScreen(_id);
}