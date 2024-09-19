package com.example.myapplication.features.login.data.model.clases

class BranchBundle(
    profiles: ArrayList<Profile>? = ArrayList(),
    branches: ArrayList<Branch>? = ArrayList(),
    businesses: ArrayList<Business>? = ArrayList()
) {
    val profiles = profiles
    val branches = branches
    val businesses = businesses

    fun addProfile(profile: Profile) {
        if (profiles != null) {
            var index = -1

            for (prof in profiles!!) {
                if (prof.id == profile.id) {
                    index = profiles!!.indexOf(prof)
                }
            }

            if (index >= 0) {
                profiles.set(index, profile)
            } else {
                profiles.add(profile)
            }
        }
    }

    fun findProfile(login: String, pass: String): Profile? {
        if (profiles != null) {
            for (prof in profiles!!) {
                if (prof.login == login && prof.pass == pass) {
                    return prof
                }
            }
        }
        return null
    }

    fun addAllProfiles(prof: ArrayList<Profile>) {
        if (profiles != null) {
            for (profile in prof) {
                addProfile(profile)
            }
        }
    }

    fun findBranch(idProfile: Int, idBusiness: Int): Branch? {
        var b: Branch? = null
        if (branches != null) {
            for (branch in branches!!) {
                if (branch.idProfile == idProfile && branch.idBusiness == idBusiness) {
                    b = branch
                }
            }
        }
        return b
    }

    fun addBranch(branch: Branch) {
        if (branches != null) {
            var index = -1

            for (b in branches) {
                if (b.idProfile == branch.idProfile && b.idBusiness == branch.idBusiness) {
                    index = branches.indexOf(b)
                }
            }

            if (index >= 0) {
                branches.set(index, branch)
            } else {
                branches.add(branch)
            }
        }
    }

    fun countBranches(idProfile: Int) : Int{
        var count = 0
        if (branches != null) {
            for (b in branches) {
                if (b.idProfile == idProfile) {
                    count++
                }
            }
        }
        return count
    }

    fun addAllBranches(br: ArrayList<Branch>) {
        if (branches != null) {
            for (branch in br) {
                addBranch(branch)
            }
        }
    }

    fun getMainBusiness(): Business? {
        var map: HashMap<Int, Int> = HashMap()
        var count: Int = 0

        for (b in businesses!!) {
            map.put(b.id!!, 0)
        }

        for (b in branches!!) {
            count = map.get(b.idBusiness)!!
            count++
            map.put(b.idBusiness!!, count)
        }

        count = 0
        var resultId = 0

        for (item in map) {
            if (item.value > count) {
                count = item.value
                resultId = item.key
            }
        }
        return businesses!!.map { it }.firstOrNull { it.id == resultId }
    }

    fun findAllBusiness(idProfile: Int) : ArrayList<Business>{
        var list: ArrayList<Business> = ArrayList()
        for(b in businesses!!){
            if(findBranch(idProfile, b.id!!) != null){
                list.add(b)
            }
        }
        return list
    }

    fun addBusiness(business: Business) {
        if (businesses != null) {
            var index = -1

            for (b in businesses) {
                if (b.code == business.code) {
                    index = businesses.indexOf(b)
                }
            }

            if (index >= 0) {
                businesses.set(index, business)
            } else {
                businesses.add(business)
            }
        }
    }

    fun addAllBusinesses(bus: ArrayList<Business>) {
        if (businesses != null) {
            for (business in bus) {
                addBusiness(business)
            }
        }
    }

}